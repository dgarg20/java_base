## Solr

## Solr Advantages
If your data is largely immutable along wiith high performance with accuracy is a priority solr is more suited for it.
2. If data is non json the best choice
3. the load can be ditributed by the developer also
4. when data is more static offers higher speed as compare to elastic search



## Solr Disadvantes

1. Range queries take more time and feature not much available.
2. Uses Zk for leader election and node discovery


## Elastic search advantages
1. easy to setup, can spin within miniutes
2. json based configuration file.
3. MOstly suited for json
4. highly dynamic in leader(master selection)
5. more tools available for monitoring
6. trouble shooting elastic search is much easier, good amount of metrics availble, easy installation and mangement.
7. if data changes to rapidly then a good choice over solr


## Elastic search Disadvantages
1. Uses Zen for distributed coordination. Requires 3 master nodes for full tolerant.
2. 