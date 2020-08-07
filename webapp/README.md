# webapp

Spring Frameworkを使ったWebアプリとなってます．

SpringBootをベースにして，ORMapperにSpringのData JPAを，ViewにThymeleafを利用しています．  
UT Frameworkには，Javaコードに近い状態でパラメータ化テストができるSpockを起用してます．

## コンポーネントの説明

|パッケージ名|役割|
|:-----|:-------|
|config|設定情報を管理する|
|controller|MVCモデルでいうControllerに位置する部分<br>基本的にここでリクエストをうけとってモデル層に処理を流す|
|domain|固有のドメインモデルを定義しておく場所|
|entity|DBのテーブルに対応するBeanクラス|
|enums|コード値や区分値を管理する場所|
|form|リクエストのBeanクラスを管理する場所|
|repository|DBにアクセスするためのインターフェイスを管理する場所|
|service|controllerからのみ呼び出される処理<br>ロジック層やドメインモデルに相当|
|util|いわゆるユーティリティクラスの集まり|
|validator|リクエストのバリデーションを行う|

上記以外に利用するもの

|場所|役割|
|:----|:----|
|resources/**|設定ファイルを管理する場所|
|WEB-INF/views/**|Thymeleafテンプレートが格納されている場所<br>Controllerの戻り値で指定される|

### configパッケージとresourcesディレクトリの使い分けについて
Springに直結する設定情報はConfigクラスを利用します．  
コンテキストパスやDB接続情報など環境に依存するものについてはresourcesディレクトリを使うようにしてあります．  


## ユニットテストについて
Spock+groovyを利用したパラメータ化テストとなってます．  
jUnitと同様にテスト対象クラスと同じパッケージ構造を持つようにします．  
コードのルートディレクトリを `src/test/groovy` とします．  

全テストコードを実行する場合，以下のコマンドを利用すれば便利です．  
※ テスト済みのものはスキップされます
```bash
gradle test
```

特定のクラスのみテストしたい場合
```bash
gradle test --tests net.coolblossom.lycee.app.web.controller.SearchBookControllerSpec
```


## 起動方法
SpringBootはTomcat同封のアプリケーションを作ることができるため以下のような手順で実行できます．  
（このファイルがあるディレクトリをカレントディレクトリとして進めていきます）

まず，Terminalで以下のコマンドを実行して，成果物を作成します．
```bash
gradle build
```

ビルトに成功すれば成果物ができるので，以下のコマンドを実行します．

```bash
# バージョンは必要に応じて読み替えてください
java -jar build/libs/webapp-0.0.1-PROTOTYPE.jar
```

webアプリを起動後，以下にアクセスすれば画面を表示することができます．

http://localhost:8080/lycee-web-library/
