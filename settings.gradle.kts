rootProject.name = "GuardTips"


fun includeProject(moduleName: String, rootFolderName: String = "") {
    settings.include(moduleName)

    if (rootFolderName.isNotEmpty()) {
        project(moduleName).projectDir =
            File(rootDir, "${rootFolderName}/${moduleName.substring(startIndex = 1)}")
    }
}



includeProject(":app")
includeProject(":data")
includeProject(":domain")
