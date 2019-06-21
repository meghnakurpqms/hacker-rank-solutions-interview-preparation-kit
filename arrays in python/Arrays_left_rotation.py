#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the rotLeft function below.
def rotLeft(a, d):
    nlist=[]
    nlist=a[d:]+a[:d]
    for var in nlist:
        print(var,end=" ")
    #print(nlist)

if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nd = input().split()
    #print("nd",nd)

    n = int(nd[0])
    #print("n",n)

    d = int(nd[1])
    #print("d",d)

    a = list(map(int, input().rstrip().split()))
    #print(a)

    result = rotLeft(a, d)

    #fptr.write(' '.join(map(str, result)))
    #fptr.write('\n')

    
    #fptr.close()
