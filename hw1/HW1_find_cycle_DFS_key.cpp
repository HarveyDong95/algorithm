#include <cstdio>
#include <cstdlib>
#include <vector>
#include <memory.h>

using namespace std;

#define MAXN 10000
#define MAXM 100000

int n, m;

vector<int> edges[MAXN];
int visited[MAXN], queue[MAXN], inqueue[MAXN];
int top;

void find_cycle(int u){
	visited[u] = 1; 
	inqueue[u] = top; queue[top++] = u;
	for (auto i = edges[u].begin(); i != edges[u].end(); i++) {
		int v = *i;
		if (visited[v]) {
			if (inqueue[v]!=-1) {
				printf("%d", top - inqueue[v]);
				for (int j = inqueue[v]; j<top; j++) {
					printf(" %d", queue[j]+1);
				}
				printf("\n");
				exit(0);
			}
		}
		else {
			find_cycle(v);
		}
	}
	inqueue[u] = -1;
	top--;
}

int main(){
	scanf("%d %d", &n, &m);
	int i, u, v;
	for (i = 0; i < m; i++) {
		scanf("%d %d", &u, &v);
		u--; v--;
		edges[u].push_back(v);
	}
	top = 0;
	memset(visited, 0, sizeof(visited));
	memset(inqueue, 0xFF, sizeof(inqueue));
/*	for (i = 0; i < n; i++)
		printf("%d ", inqueue[i]); 
	printf("\n");*/
	for (i = 0; i < n; i++)
		if (!visited[i]) 
			find_cycle(i);
	printf("%d\n", 0);
	return 0;
}
