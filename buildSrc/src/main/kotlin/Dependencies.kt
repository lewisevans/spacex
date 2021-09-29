import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.coroutines() {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.4")
}

fun DependencyHandler.activityX() {
    implementation("androidx.activity:activity-ktx:1.1.0")
}


fun DependencyHandler.lifecycle() {
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")
}

fun DependencyHandler.constraintLayout() {
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta6")
}

fun DependencyHandler.hilt() {
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha01")
    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha01")
}

fun DependencyHandler.room() {
    val roomVersion = "2.2.5"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    /*implementation "androidx.room:room-coroutines:$room_version"*/
    kapt("androidx.room:room-compiler:$roomVersion")
}

fun DependencyHandler.paging() {
    val pagingVersion = "3.0.0-alpha06"
    implementation("androidx.paging:paging-runtime:$pagingVersion")
}

fun DependencyHandler.retrofit() {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.8.0")
}

fun DependencyHandler.glide() {
    implementation("com.github.bumptech.glide:glide:4.11.0")
    kapt("com.github.bumptech.glide:compiler:4.11.0")
}

fun DependencyHandler.mockWebService() {
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
}

///////////////
// HELPERS:
///////////////

private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}