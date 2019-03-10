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

with open(sys.argv[1]) as file:
    file = file.readlines()

op_num = int(file[0].split(' ')[1])
elem_num = int(file[0].split(' ')[0])

qf = UnionFind(elem_num)

for i in range(op_num):
    op = file[i+1].split(' ')[0]
    if op == 'M':
        # print('m')
        node1 = int(file[i+1].split(' ')[1]) -1
        node2 = int(file[i+1].split(' ')[2]) -1
#         print(node1,node2)
        qf.union(node1,node2)
    elif op == 'Q':
        # print('q')
        node3 = int(file[i+1].split(' ')[1])
        res = qf.id
        res2 = res[node3-1]
        final = res.count(res2)
        print(final)