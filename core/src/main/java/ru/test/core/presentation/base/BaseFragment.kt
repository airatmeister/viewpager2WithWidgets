package ru.test.core.presentation.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import dagger.android.support.AndroidSupportInjection
import ru.test.core.plugins.BasePlugin
import ru.test.core.plugins.LifecycleEvent
import ru.test.core.plugins.viewbinding.ViewBindingPlugin
import ru.test.core.presentation.Navigator
import timber.log.Timber
import javax.inject.Inject

abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {
    val bindingPlugin = ViewBindingPlugin()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected open fun provideStoreOwner(): ViewModelStoreOwner = this
    protected lateinit var navigator: Navigator

    private val plugins = mutableListOf<BasePlugin>()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initPlugins()
        dispatchEventToPlugins(LifecycleEvent.BeforeOnCreate(savedInstanceState))
        super.onCreate(savedInstanceState)
        dispatchEventToPlugins(LifecycleEvent.OnCreate(savedInstanceState))
        callOperations()
        navigator = requireActivity() as Navigator
        // Timber.d("onCreate $this")
    }

    override fun onResume() {
        dispatchEventToPlugins(LifecycleEvent.OnResume)
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Timber.d("onViewCreated $this")
        dispatchEventToPlugins(LifecycleEvent.OnViewCreated(view, savedInstanceState))
        onSetupLayout(savedInstanceState)
        onBindViewModel()
    }

    override fun onPause() {
        dispatchEventToPlugins(LifecycleEvent.OnPause)
        super.onPause()
    }

    override fun onStart() {
        super.onStart()
        dispatchEventToPlugins(LifecycleEvent.OnStart)
    }

    override fun onStop() {
        dispatchEventToPlugins(LifecycleEvent.OnStop(this))
        super.onStop()
    }

    override fun onDestroyView() {
        dispatchEventToPlugins(LifecycleEvent.OnDestroyView(this))
        Timber.d("onDestroyView $this")
        super.onDestroyView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        dispatchEventToPlugins(LifecycleEvent.OnActivityResult(requestCode, resultCode, data))
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        dispatchEventToPlugins(LifecycleEvent.OnSaveInstanceState(outState))
    }

    override fun onDestroy() {
        dispatchEventToPlugins(LifecycleEvent.OnDestroy)
        Timber.d("onDestroy $this")
        releasePlugins()
        super.onDestroy()
    }

    /**
     * Вызывать методы вью модели, которые получают данные из репозиториев
     */
    abstract fun callOperations()

    /**
     * В этом методе производить все настройки вью фрагмента
     * установка OnClickListener, RecyclerView.Adapter/LayoutManager, etc
     */
    abstract fun onSetupLayout(savedInstanceState: Bundle?)

    /**
     * В этом методе производить подписки на изменения значений в лайвдатах у ViewModel
     */
    abstract fun onBindViewModel()

    // region Plugins
    @CallSuper
    protected open fun initPlugins() {
        addPlugin(bindingPlugin)
    }

    protected fun addPlugin(plugin: BasePlugin) {
        plugins.add(plugin)
    }

    private fun dispatchEventToPlugins(event: LifecycleEvent) {
        plugins.forEach { it.onLifecycleEvent(event) }
    }

    private fun releasePlugins() {
        plugins.clear()
    }

    // end region Plugins

    protected infix fun <T> LiveData<T>.observe(block: (T) -> Unit) {
        observe(this@BaseFragment.viewLifecycleOwner, { t -> block.invoke(t) })
    }

    @MainThread
    inline fun <reified VM : ViewModel> Fragment.settingsViewModels() =
        createViewModelLazy(VM::class, { this.viewModelStore }, { viewModelFactory })
}