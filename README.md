

# activity-alias

这个 activity-alias 仅作为标记使用，并没有 class 类，并通过 enabled 属性来确认是否启用。关于这个 activity-alias 的使用，可以用来动态替换图标

我们能通过 <activity-alias> 标签为每个 Activity 注册一个“别名”, 通过这个别名就能启动对应的目标 Activity
它最重要的属性是:android:enabled 属性，布尔类型，是否开启别名设置，默认值为 true；

对于activity-alias标签，它有一个属性叫android:targentActivity，这个属性就是用来为该标签设置目标Activity的，或者说它就是这个目标Activity的别名。
activity-alias作为一个已存在Activity的别名，则应该可以通过该别名标签声明快速打开目标Activity。
因此activity-alias可用来设置某个Activity的快捷入口，可以放在桌面上或者通过该别名被其他组件快速调起。


- 1. android:enable 

> 该属性用来决定目标Activity可否通过别名被系统实例化，默认为true。
需要注意的是application也有enable属性，只用当它们同时为true时，activity-alias的enable才生效。

- 2. android:exported 

> 该属性为true的话，则目标Activity可被其他应用调起，如为false则只能被应用自身调起。
其默认值根据activity-alias是否包含intent-filter元素决定，如果有的话，则默认为true；没有的话则为false。
其实也很好理解，如果有intent-filter，则目标Activity可以匹配隐式Intent，因此可被外部应用唤起；
如果没有intent-filter，则目标Activity要被调起的话必须知道其精确类名，因为只有应用本身才知道精确类名，所以此时默认为false。

- 3. android:icon 

> 该属性就比较好玩了，允许自定义icon，可以不同于应用本身在桌面的icon。如果需要在桌面上创建快捷入口，也许产品会要求换个不同的icon。

- 4. android:label 

> 该属性类似于android:icon，图标都换了，换个名称也合情合理吧，此属性就是为此而生的。

- 5. android:name 

> 该属性可以为任意字符串，但最好符合类名命名规范。activity元素的name属性实质上都会指向一个具体的Activity类，而activity-alias的name属性仅作为一个唯一标识而已。

- 6. android:permission 

> 该属性指明了通过别名声明调起目标Activity所必需的权限。

- 7. android:targetActivity 

> 该属性指定了目标Activity，即通过activity-alias调起的Activity是哪个，此属性其实类似于activity标签中的name属性，需要规范的Activity包名类名。





