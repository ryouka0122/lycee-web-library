<html>
<body>

<h1>REGISTER</h1>

<a href="${ctx}/logout/">ログアウト</a><br />
<br />
<a href="${ctx}/login/">ログインへ</a><br />


<div>
<div>登録情報</div>

<form action="${ctx}/register/doConfirm" method="POST">
	<table>
		<tr>
			<th>ユーザ名</th><td><input type="text" placeholder="foo" name="userName"/></td>
		</tr>
		<tr>
			<th>パスワード</th><td><input type="password" name="paswd"/></td>
		</tr>
		<tr>
			<th>パスワード(確認用)</th><td><input type="password" name="pswdCfm"/></td>
		</tr>
	</table>
	<button type="submit" name="doRegister" value="登録">登録</button>
</form>
</div>

</body>
</html>