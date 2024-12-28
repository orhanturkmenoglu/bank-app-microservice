# Dockerfile for accounts service
FROM openjdk:17-jdk-slim

# MAINTAINER : Yazar bilgilerini belirtmek için kullanılır
MAINTAINER orhanturkmenoglu.com

# COPY : Dockerfile'de kullanmak istedığimiz  JAR dosyalarını docker image içerisine  kopyalar
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#ENTRYPOINT : GİRİŞ NOKTASI DOCKER İMAGE BAŞLATMAK İCİN KULLANILAN KOMUTLARI VERDİK
ENTRYPOINT ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]


# docker build . : Dockerfile dosyamızı kullanarak docker imajımızı oluşturmamızı sağlar isimi rastgele olusturur
# docker build -t naming : docker file dosyamızı kullanarak docker imajımızı oluşturmamızı sağlar.
# docker run -p 8080:8080 naming : oluşturdugumuz docker imajının 8080 portunu 8080 portunda çalıştırır
# docker run -p -d 8080:8080 naming : oluşturdugumuz docker imajının 8080 portunu 8080 portunda
 #çalıştırır ve arka planda calısmasını sağlarız.


# özel bir isim oluşturmak için docker build -t  komutunu kullanabilirsiniz
# docker build -t spring_docker_name  : Dockerfile dosyanızın bulunduğu dizinde terminal veya komut istemcisinde şu komutu çalıştırarak Docker imajınızı oluşturabilirsiniz: