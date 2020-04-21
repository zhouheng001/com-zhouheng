#!/usr/bin/python3
# -*- coding:utf-8 -*-
#
from rediscluster import StrictRedisCluster

key = '/meme/activity/5070/2/anchor/1/1'

taskMap = {'101060': 100, '101065': 10, '101061': 5}

giftKey = '/meme/activity/5070/2/anchor/{0}/gift/1/1'

redisCluster = StrictRedisCluster(host='java-redis.ozdidq.clustercfg.apse1.cache.amazonaws.com', decode_responses=True,
                                  port=6379, skip_full_coverage_check=True)
anchorDatas = redisCluster.zrevrange(key, 0, 2000,withscores=True)
print("查主播前2000=", len(anchorDatas))
print()

print("查询礼物===========================================" + str(taskMap))

for anchorData in anchorDatas:
    myGiftKey = giftKey.format(anchorData[0])
    giftDatas = redisCluster.zrevrange(myGiftKey, 0, -1, withscores=True)
    strdata = anchorData[0]
    isPrint =0
    for giftData in giftDatas:
        if giftData[0] in taskMap:
            if giftData[1] >= taskMap.get(giftData[0]):
                isPrint = 1
                strdata = strdata + ' 任务:礼物id->' + giftData[0] + '完成'
            #else:
            #print(' 任务:','礼物id->',giftData[0], taskMap.get(giftData[0]),'个', '未完成',end='')
    if isPrint == 1 : print(strdata)