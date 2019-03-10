#include <bits/stdc++.h>
using namespace std;
const int maxn = 505;
struct node
{
	int v, next;
}edge[maxn*maxn];
int degree[maxn], head[maxn];
queue<int> q;
list<int> ans; 
int n, m, no;
inline void init()
{
	no = 0;
	while(!q.empty()) q.pop();
	memset(degree, 0, sizeof degree);
	memset(head, -1, sizeof head);
}
inline void add(int u, int v)
{
	edge[no].v = v;
	edge[no].next = head[u];
	head[u] = no++;
}
int Kahn()
{
	int count = 0;
	while(!q.empty())
	{
		int tp = q.front(); q.pop();
		++count; ans.push_back(tp);	//加入链表中，加入数组或者vector或者queue都无所谓 
		int k = head[tp];
		while(k != -1)
		{
			--degree[edge[k].v];
			if(!degree[edge[k].v]) q.push(edge[k].v);
			k = edge[k].next;
		}
	}
	if(count == n) return 1;
	return 0;
}
int main()
{
	int u, v;
	scanf("%d %d", &n, &m); init();
	for(int i = 1; i <= m; ++i)
	{
		scanf("%d %d", &u, &v);
		add(u, v); ++degree[v];
	}
	for(int i = 1; i <= n; ++i)
	{
		if(!degree[i]) q.push(i);
	}
	Kahn();
	list<int>::iterator it;
	for(it = ans.begin(); it != ans.end(); ++it)
	{
		cout << *it << " ";
	}
	cout << endl;
	return 0;
}