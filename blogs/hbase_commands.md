# Hbase Commands

### Checking the status of hbase cluster
```bash
$ status
```

## Describe the table structure
```bash
$ describe '<table_name>'
```

## version of hbase
```bash
$ version
```

## logged in via which user and auth mechanism
```bash
$ whoami
```

## listing all the hbase tables
```bash
$ list
```

## Describing each table
```bash
$ describe <tablename> 
```

## creating new table
```bash
$ create '<table name>' , '<column family1>' 
```



## Scan the content of the table
```bash
$ scan '<table_name>'
```

## Scan row keys with a limit
```bash
$ scan '<table_name>', {LIMIT=>10}
```

## Scan from a specific row till specific row key
```bash
$ scan '<table_name>', {STARTROW => 416, ENDROW => 417}
```

## Scan table for row key maching prefix
```bash
$ scan ‘tracking_events’, {ROWPREFIXFILTER => ‘416’}
$ scan ‘tracking_entities’, {ROWPREFIXFILTER => ‘416’}
```

## get specific row from table
```bash
$ get '<table name>' , '<row_key>'
```

## get specific column value for the row key based on timestamp 
```bash
$ get '<table name>' , '<row_key>', {column=>'<column family>:<column name>', <TimeStamp>=>12451615426765267}
```

## get specific column value for the row key
```bash
$ get '<table name>' , '<row_key>', {column=>'<column family>:<column name>'}
```

## get all version of column value for the row key

Will display only that many versions as configured in hbase to store for the particular table
```bash
$ get '<table name>' , '<row_key>', {column=>'<column family>:<column name>', VERSIONS=>10}
```



## Puting into hbase table 
```bash
$ put '<table name>', '<row_key>', '<column_family>:<column_name>', '<column_value>' , 
```

## update into hbase table 
```bash
$ put '<table name>', '<row_key>', '<column_family>:<column_name>', '<modified_column_value>' , 
```

## Checking the status of hbase cluster
```bash
$ alter 'store_view',{NAME=>'data',REPLICATION_SCOPE=>1}
```

## Disable hbase table
```bash
$ disable <tablename> 
```

## enable hbase table
```bash
$ enable <tablename> 
```

## Alter hbase table
```bash
$ disable '<tablename>' 
$ alter '<table>'
$ alter 'vertical_brand',{NAME=>'data',REPLICATION_SCOPE=>1} #example
$ enable '<tablename>' 
```

## drop hbase table
```bash
$ disable '<tablename>' 
$ drop '<table>'
```


## Describing each tbale
```bash
$ describe <tablename> 
```











## Update Replication Scope 
```bash
>alter 'store_view',{NAME=>'data',REPLICATION_SCOPE=>1}
```

## Put Serial Number Rule
```bash
>put 'serial_number_rule','IFB','data:regular_expression','^.*(1[0-9]|2[0-5])(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1]|)[0-9]{6}$'
```

## Hbase Dump
```bash
>echo "scan 'product_packages'" | hbase shell > tmp.txt echo "count 'store_view', { INTERVAL => 1 }" | hbase shell > tmp2.txt
```

## Scan multiple columns
```bash
>scan 'vertical' , {COLUMNS => ['data:lmi_enabled' , 'data:sku_defn_attributes']}
```

```bash
$ count '<tableName>'
```

```bash
>list
```

```bash
>list
```



## get all row keys from table : 
```bash
> count '<table_name>', { INTERVAL => 1 }
```

scan 'tracking_events' , {STARTROW => '0018df74-7e7b-4ce9-8c7d-a92e53bf275e:1491206816417', STOPROW => '0018df74-7e7b-4ce9-8c7d-a92e53bf275e:1491206816417{‘}0018df74-7e7b-4ce9-8c7d-a92e53bf275e:1491206816417 16417

scan ‘tracking_events’, {LIMIT=>10}
scan ‘tracking_events’, {ROWPREFIXFILTER => ‘416’}
scan ‘tracking_entities’, {ROWPREFIXFILTER => ‘416’}
scan 'tracking_events', {STARTROW => 416, ENDROW => 417}

get 'tracking_events',’746'

create 'vertical_brand',’data'
disable ‘vertical_brand'
alter 'vertical_brand',{NAME=>'data',REPLICATION_SCOPE=>1}


scan 'mytable', {ROWPREFIXFILTER => 'abc’}scan 'mytable', {STARTROW => 'abc', ENDROW => 'abd’}
