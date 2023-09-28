1. 安装
2. 安装分词器（每个版本都不一样）
https://github.com/medcl/elasticsearch-analysis-ik
3. 按照文档分词
curl -XPOST http://localhost:9200/index/_mapping -H 'Content-Type:application/json' -d'
{
        "properties": {
            "content": {
                "type": "text",
                "analyzer": "ik_max_word",
                "search_analyzer": "ik_smart"
            }
        }

}'
4. 如果错了mapping 无解 查看api
```
GET /<index>/_mapping
```

5. 解决办法 建一个索引 a 建一个真的b alia过去 如果b错了 建个c 然后把c换掉b 导入数据的方法

```
POST _reindex
{
    "source": {
        "index": "dynamic_data_v2"
    },
    "dest": {
        "index": "dynamic_data_v5"
    }
}
```