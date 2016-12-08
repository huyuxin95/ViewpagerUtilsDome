# ViewpagerUtilsDome
这是viewpager 的工具类也是我写的第一个依赖库,如果你想用它,你需要在你的module的build.gradle的文件的dependencies节点下添加compile 'com.huyuxin:viewpagerutils_v1:1.0.0'
如何添加?
举个例子,在你添加之前
"
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:23.4.0'
    testCompile 'junit:junit:4.12'
}
"
在你添加之后
"
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:23.4.0'
    compile 'com.huyuxin:viewpagerutils_v1:1.0.0'
    testCompile 'junit:junit:4.12'
}
"
(蹩脚英语翻译一波)
this is a viewpager utils for my first write dependencie file.
in your module's build.gradle dependencies add "   compile 'com.huyuxin:viewpagerutils_v1:1.0.0'  " if you want use it.
ex.before  you add
"
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:23.4.0'
    testCompile 'junit:junit:4.12'
}
"
after you add
"
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:23.4.0'
    compile 'com.huyuxin:viewpagerutils_v1:1.0.0'
    testCompile 'junit:junit:4.12'
}
"
