# lycee-web-library

開発の仕方は以下のような流れ

1. 環境構築
2. コード開発
3. gradleでwar作成
4. Webアプリ起動
6. ブラウザで動作確認


# プロジェクトの中身について

一式揃ってる状態になってます．  
必要なツールをインストールすれば，すぐに開発できるようなります．

## インストールするもの
* Gradle
* IntelliJ (Eclipseでも代用可だが未確認)
* Docker

## プロジェクトの構成
ここには，Webアプリとデータベースの2つが入ってます．

### Webアプリ
webappディレクトリのなかに全て入ってます．  
Spring Bootを使用したプロジェクトです．

ビルド成果物は，Tomcat同封warとなります．  
なので，warファイルを実行すれば，サーバーが起動します．

```bash
java -jar webapp/build/libs/webapp.jar
```

### データベース
databaseディレクトリの中に全て入ってます．  
Dockerを利用してMariaDBを使うようにしてあります．

コンテナ作成は以下のようにします．
```bash
docker-compose up --no-start
```

起動は，次のコマンド
```bash
docker-compose up -d
```
