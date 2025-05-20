CREATE KEYSPACE IF NOT EXISTS twitter_keyspace
WITH replication = {
  'class': 'SimpleStrategy',
  'replication_factor': 1
};