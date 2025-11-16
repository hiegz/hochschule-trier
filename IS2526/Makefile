default:

4.8:
	openssl genrsa -out keypair.key 2048
	openssl req -new -key keypair.key -out request.csr
	openssl x509 -req -in request.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out vlbt3535.crt -days 365
	openssl pkcs12 -export -out vlbt3535.pfx -in vlbt3535.crt -inkey keypair.key -certfile ca.crt
