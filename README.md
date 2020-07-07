# MergeMultiTxt
## 使用说明：
1. 同一本小说各txt存放在同一文件夹下，合成的txt文件将以文件夹名为文件名。
2. bat和jar文件位置与小说文件夹同等级。
即
```
|--novelADir
	|--novelA_1.txt
	|--novelA_2.txt
	|--novelA_3.txt
|--novelBDir
	|--novelB_1.txt
	|--novelB_2.txt
	|--novelB_3.txt
|--novelCDir
	|--novelC_1.txt
	|--novelC_2.txt
	|--novelC_3.txt
|--merge.bat
|--MergeMultiTxt.jar
```
3. 同时合成所有文件夹下的txt。合成后可检查然后删除文件夹。
## 使用`calibre`转mobi
1. 外观界面
    1. 文本 -> 规范标点
    2. 布局
        1. 删除段落空行 -> 缩进 `2.0 em`
        2. 在段落间插入空行 -> 行间距 `1.0em`
2. 页面设置 -> 输出配置文件 -> 合适版本
3. 内容目录 -> 一级目录`//h:h1`
4. MOBI输出 -> 文件类型`both`