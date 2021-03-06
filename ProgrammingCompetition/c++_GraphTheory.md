
###Dijkstra, untested

``` c++
#include <queue>
#include <vector>

// PITFALL: Make sure **weights is setup correctly and points to the correct array pointers
int dijkstra( int **weights, int n, int start, int end ) {

	int dist[n];
	for (int i = 0; i < n; i++) dist[i] = INF;
	dist[start] = 0;

	priority_queue <Node> q;
	q.push( Node( start, 0 ) );

	while ( q.size() > 0 ) {

		Node node = q.top();
		q.pop();

		if (dist[node.index] < node.dist) 
			continue;

		if (node.index == end) 
			return node.dist;

		for (int i = 0; i < n; ++i) {
			if (weights[node.index][i] != INF)  {
				int newDist = dist[node.index] + weights[node.index][i];
				if (newDist < dist[i]) {
					dist[i] = newDist;
					q.push( Node(i, newDist) );
				}
			}
		}
	}
	return -1;
}

struct Node {
    int index, dist;
    Node (int i, int d) : index(i), dist(d) { }

    bool operator < (const Node& rhs) const {
        return dist < rhs.dist;
    }
};

```
