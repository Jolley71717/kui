import org.gradle.api.Plugin
import org.gradle.api.Project

class DownloadFirefoxPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        // Plugin is applied but does not automatically register tasks
        // Tasks will be registered manually in the consuming build script
    }
}
