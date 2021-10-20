# Hbase Key terms

- Hmaster  - 
- NameNode - 
- RegionServer - 
- Data Node - 
- Zookeeper - 
- Hfile - 
- Bloom Filter - 
- WAL - 
- Block Cache - 
  - On Heap - 
  - Off Heap - 

## Hbase CAP Theorem
Is a CA system


## Advantages of HBase Architecture
There are some benefits which HBase Architecture offers:
a. Strong consistency model
– All readers will see same value, while a write returns.
b. Scales automatically
– While data grows too large, Regions splits automatically.
– To spread and replicate data, it uses HDFS.
c. Built-in recovery
– It uses Write Ahead Log for recovery.
d. Integrated with Hadoop
– On HBase MapReduce is straightforward.

## Limitations With Apache HBase
1. Business continuity reliability
  – Write Ahead Log replay very slow.
  – Also, a slow complex crash recovery.
  – Major Compaction I/O storms.


Hbase Components in Depth



Setup Hbase On production



## HBase META Table
META Table is a special HBase Catalog Table. Basically, it holds the location of the regions in the HBase Cluster.

- It keeps a list of all Regions in the system.
- Structure of the .META. table is as follows:
- Key: region start key, region id
- Values: RegionServer
It is like a binary tree.




## Compaction in Hbase

## Hbase Commands


## Hbase compared to other Tech over Hadoop


## Hbase Read Path


## HBase Write Path


## Key Things while using Hbase
Hotspotting in keys for a table


Hbase how region Split works
A region is decided to be split when store file size goes above hbase.hregion.max.filesize or according to defined region split policy.
At this point this region is divided into two by region server.
Region server creates two reference files for these two daughter regions.
These reference files are stored in a new directory called splits under parent directory.
Exactly at this point, parent region is marked as closed or offline so no client tries to read or write to it.
Now region server creates two new directories in splits directory for these daughter regions.
If steps till 6 are completed successfully, Region server moves both daughter region directories under table directory.
The META table is now informed of the creation of two new regions, along with an update in the entry of parent region that it has now been split and is offline. (OFFLINE=true , SPLIT=true)
The reference files are very small files containing only the key at which the split happened and also whether it represents top half or bottom half of the parent region.
There is a class called “HalfHFileReader”which then utilizes these two reference files to read the original data file of parent region and also to decide as which half of the file has to be read.
Both regions are now brought online by region server and start serving requests to clients.
As soon as the daughter regions come online, a compaction is scheduled which rewrites the HFile of parent region into two HFiles independent for both daughter regions.
As this process in step 12 completes, both the HFiles cleanly replace their respective reference files. The compaction activity happens under .tmp directory of daughter regions.
With the successful completion till step 13, the parent region is now removed from META and all its files and directories marked for deletion.
Finally Master server is informed by this Region server about two new regions getting born. Master now decides the fate of the two regions as to let them run on same region server or have them travel to another one.

Source[https://community.cloudera.com/t5/Community-Articles/How-Region-Split-works-in-HBase/ta-p/248814]


## Refereneces
1. Hbase vs Cassandra [http://bigdatanoob.blogspot.com/2012/11/hbase-vs-cassandra.html]
2. GC tuning Hbase [https://blogs.apache.org/hbase/entry/tuning_g1gc_for_your_hbase]
3. Hbase Guide [https://hbase.apache.org/book.html#hbase_metrics]


Hbase follows 3 serves in master slave architecture
    - Hbase master - use to Create delte tables and store meta data
    - Region server - region servert are composed of regions where actually data is stored
    - Zookeeper - Maintain overall cluster help

    The NameNode maintains metadata information for all the physical data blocks that comprise the files.
