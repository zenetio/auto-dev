package cc.unitmesh.ide.javascript.flow

import cc.unitmesh.devti.flow.TaskFlow

/**
 * FrontendFlow is an interface that represents the flow of tasks in a frontend application.
 * It provides methods for retrieving routes, components, design system components, remote calls, and state management.
 *
 * Based on our workflow design rules: [Workflow](http://ide.unitmesh.cc/workflow)
 *
 * 1. Functional bootstrap
 * 2. Request Transform / Data validation, IO Handing.
 * 3. Process IPC/RPC Calling
 * 4. Output Transform / Render
 */
interface FrontendFlow : TaskFlow<String> {
    var userTask: String

    /**
     * Get all routes in the project, including the routes in the submodules
     * @return list of routes
     */
    fun getRoutes(): List<String>

    /**
     * Get all components in the project, based on the naming convention, like the PascalCase under `src/components`
     * @return list of components
     */
    fun getComponents(): List<DsComponent>

    /**
     * Get the design system components, like the Ant Design in React.
     * Which will load the design system components from the remote
     * @return list of design system components
     */
    fun getDesignSystemComponents(): List<DsComponent>

    /**
     * Get remote call as a sample, like the axios in Vue, the fetch in React
     * @return list of services
     */
    fun sampleRemoteCall(): String

    /**
     * Get the state management as a sample, like the Vuex in Vue, the Redux in React, maybe Empty
     * @return list of state management
     */
    fun sampleStateManagement(): String?
}
