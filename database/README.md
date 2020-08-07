# database

lycee-web-libraryのデータベース周りを管理する場所です．  

初期データはこちらにあるデータを元に組み立ててあります．  
https://www.aozora.gr.jp/

データベースはDockerを利用してMariaDBを使います．  
DB自体の設定は../docker-compose.yamlに記載してあります．  
イメージを作る際は，このディレクトリにDockerfileを作成して，../docker-compose.yamlから呼び出すようにします．

## DBコンテナについて
初期データをdatasets，初期実行SQLをinitdb.dに入れておくとDB初期化の時に実行してくれます．


## データベースの設定値

|項目|docker-compose.yaml|設定値|
|:---|:---|:---|
|DBバージョン|----|(最新版)|
|コンテナ名|----|mariadb|
|接続ポート|portsの左側のポート番号|3306|
|DBの文字コード|--character-set-server|UTF8(utf8mb4)|
|接続時の文字コード|--collation-server|UTF8(utf8mb4_unicode_ci)|
|タイムゾーン|TZ|Asia/Tokyo|

DB自体の設定は，my.cnfに記載すること．


## datasetsの中身について
初期データをCSV形式で用意しておきます．  
1行目は管理用に使えるようにしてあります．（読み込み時スキップしてあります）  
各項目は，"  "とダブルクウォートでくくるようにしててください．また，改行コードは\nとしてください．  

ファイルロードは以下のようなSQLになります．  
```sql
load data local infile '/datasets/users.csv' into table users fields terminated by ',' enclosed by '"' lines terminated by '\n' ignore 1 lines;
```

## initdb.dの中身について
このディレクトリごと，コンテナの初期化ディレクトリ/docker-entrypoint-initdb.dにマウントされます．そして，アルファベット順にファイルが実行されます．  


## 永続化データについて
コンテナを実行すると永続化データをマウントさせてあるdatabase/volumesのディレクトリに退避するようになっています．
そのため，コンテナを作り直してもデータは残り続けます．

DB自体をリセットしたい場合は，コンテナを停止してvolumesディレクトリごと消したのち，コンテナを起動させてください．
