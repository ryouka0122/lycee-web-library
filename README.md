# lycee-web-library

開発の仕方は以下のような流れ

1. Eclipseでコード開発
2. gradleでwar作成
3. gradleを使ってTomcatにデプロイ
4. gradleでTomcatの起動/停止
5. ブラウザで動作確認


## gradleの使い方
### Eclipse用プロジェクトの作成
```
gradle eclipse
```

### ビルド（warファイルの作成）
```
gradle war
```

### デプロイ
このタスクでは環境変数に `TOMCAT_HOME` があり，そのディレクトリを起点にデプロイします．
```
gradle deploy
```

### Tomcatの起動/停止
```
# Tomcatの停止
gradle shutdown

# Tomcatの起動
gradle startup

# Tomcatの再起動(内部ではshutdownとstartupを呼びだしているだけ)
gradle reboot
```

### ビルドから起動まで
```
gradle war shutdown deploy startup
```


# Misc.
## Tomcatのログが文字化けする
{TOMCAT_HOME}/conf/logging.propertiesがcatalina.outのログ設定ファイルとなっている．
UTF-8設定にあっているがWindowsのコンソールがSJISになっているため，文字コードが合わず化けてしまう．
以下のように変えることで文字化けを解消することが出来る（変更後Tomcat再起動が必要）
```
#java.util.logging.ConsoleHandler.encoding = UTF-8
java.util.logging.ConsoleHandler.encoding = SJIS
```
