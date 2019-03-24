import sys
class UnionFind(object):
    id = []
    count = 0
    def __init__(self,n):
        self.count = n
        i = 0
        while i < n:
            self.id.append(i)
            i += 1

    def connected(self,p,q):
        return self.find(p) == self.find(q)

    def find(self,p):
        return self.id[p]

    def union(self,p,q):
        idp = self.find(p)
        if not self.connected(p,q):
            for i in range(len(self.id)):
                if self.id[i] == idp:
                    self.id[i] = self.id[q]
            self.count -= 1


#with open(sys.argv[1]) as inputfile:
#    inputfile = inputfile.readlines()
temp = input()
nums = int(temp.split(' ')[0]) + 1
line = int(temp.split(' ')[1])

#op_num = int(inputfile[0].split(' ')[1])
#elem_num = int(inputfile[0].split(' ')[0])

qf = UnionFind(nums)

for i in range(line):
    inputfile = input()
    op = inputfile[0]
    if op == 'M':
        node1 = int(inputfile.split(' ')[1]) #int(inputfile[i+1].split(' ')[1]) -1
        node2 = int(inputfile.split(' ')[2]) #int(inputfile[i+1].split(' ')[2]) -1
#         print(node1,node2)
        qf.union(node1,node2)
    elif op == 'Q':
        node3 = int(inputfile.split(' ')[1])#int(inputfile[i+1].split(' ')[1])
        res = qf.id
        res2 = res[node3]
        final = res.count(res2)
        final = str(final)
        print(final)
