from redis import StrictRedis

host = "infbdt14.fh-trier.de"
port = "6379"
user = "bigdataXYZ"
password = "streng-geheim"

redis = StrictRedis(host, port, username = user, password = password)

redis.set(user + ":foo", "bar".encode("utf-8"))
print(redis.get(user + ":foo").decode("utf-8"))
