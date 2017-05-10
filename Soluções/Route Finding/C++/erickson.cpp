#include <iostream>
#include <stack>
#include <map>
#include <vector>

bool contains(const int& node, const std::vector<int>& v)
{
	for (unsigned int i = 0; i != v.size(); ++i)
	{
		if (v[i] == node)
		{
			return true;
		}
	}
	return false;
}

class graph
{
public:
	graph() : m_found(false)
	{
	}

	~graph()
	{
	}

	void add_edge(const int node, const int edge)
	{
		std::map< int, std::vector<int> >::iterator it = m_nodes.find(node);
		if (it != m_nodes.end())
		{
			it->second.push_back(edge);
		}
		else
		{
			std::vector<int> edges;
			edges.push_back(edge);
			m_nodes.insert(std::make_pair(node, edges));
			m_visited.insert(std::make_pair(node, false));
		}
	}

	bool found() const
	{
		return m_found;
	}

	void is_reachable(int item)
	{
		std::stack<int> stack;
		stack.push(item);
		m_visited[item] = true;

		while (true)
		{
			std::map< int, std::vector<int> >::const_iterator it = m_nodes.find(item);
			if (it != m_nodes.end())
			{
				std::vector<int> edges = it->second;
				for (unsigned int i = 0; i != edges.size(); ++i)
				{
                    int edge = edges[i];
					if (!m_visited[edge])
					{
						if (edge == 99)
						{
							m_found = true;
							return;
						}
						stack.push(edge);
						m_visited[edge] = true;
						is_reachable(edge);
					}
				}
			}
			if (!stack.empty())
			{
				item = stack.top();
				stack.pop();
			}
			else
			{
				break;
			}
		}
	}

private:
	std::map< int, std::vector<int> > m_nodes;
	std::map<int, bool> m_visited;
	bool m_found;
};

int main(int argc, const char** argv)
{
	unsigned int i;
	const unsigned int max_tests = 10;
	for (i = 0; i != max_tests; ++i)
	{
		unsigned tc, edges;
		std::cin >> tc >> edges;
		unsigned int j;

		graph* g = new graph;

		for (j = 0; j != edges; ++j)
		{
			unsigned int e1, e2;
			std::cin >> e1 >> e2;
			g->add_edge(e1, e2);
		}

		g->is_reachable(0);

		std::cout << "#" << tc << " " << g->found() << std::endl;

		delete g;
	}

	return 0;
}
