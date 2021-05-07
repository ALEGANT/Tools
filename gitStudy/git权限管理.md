1. ssh-genkey -t rsa "邮箱" 生成key(id_rsa, id_rsa.pub)
2. 进入github头像点击setting
3. 添加ssh密钥
4. title随意,打开生成的文件(id_rsa.pub),复制文件里面的内容到key选项里
5. 保存.然后复制id_rsa,把复制的文件后缀修改为.ppk,添加到sourcetree即可使用
