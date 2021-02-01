
:: Compile the client program
call ant -f build_client.xml jar


:: Run the server program, pass port as an argument.
java -jar build_client/jar/Client.jar 127.0.01 5002

call ant -f build.xml
pause;