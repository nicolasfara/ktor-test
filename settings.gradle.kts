plugins {
    id("com.gradle.enterprise") version "3.12"
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishOnFailure()
    }
}

rootProject.name = "ss-api"
enableFeaturePreview("VERSION_CATALOGS")

val gitHook = File(".git${File.separator}hooks${File.separator}commit-msg")
if (!gitHook.exists()) {
    val file = """
        #!/usr/bin/env sh

        # Create a regex for a conventional commit.
        convetional_commit_regex="^(build|chore|ci|docs|feat|fix|perf|refactor|revert|style|test)(\([a-z \-]+\))?!?: .+${'$'}"

        # Get the commit message (the parameter we're given is just the path to the
        # temporary file which holds the message).
        commit_message=${'$'}(cat "${'$'}1")

        # Check the message, if we match, all good baby.
        if [[ "${'$'}commit_message" =~ ${'$'}convetional_commit_regex ]]; then
           echo -e "\e[32mCommit message meets Conventional Commit standards...\e[0m"
           exit 0
        fi

        # Uh-oh, this is not a conventional commit, show an example and link to the spec.
        echo -e "\e[31mThe commit message does not meet the Conventional Commit standard\e[0m"
        echo "An example of a valid message is: "
        echo "  feat(login): add the 'remember me' button"
        echo "More details at: https://www.conventionalcommits.org/en/v1.0.0/#summary"
        exit 1
        
    """.trimIndent()
//    gitHook.writeText(file, Charsets.UTF_8)
//    gitHook.setExecutable(true)
}