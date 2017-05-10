#include <iostream>

const unsigned int involve(const unsigned& a, const unsigned int& b)
{
    if (b == 0)
    {
        return 1;
    }
    if (b == 1)
    {
        return a;
    }
    else
    {
        return a * involve(a, b - 1);
    }
}

int main(int argc, const char** argv)
{
    const unsigned int maximum_test_cases = 10;

    unsigned int test_case, a, b, i;

    for (i = 0; i != maximum_test_cases; ++i)
    {
        std::cin >> test_case;
        std::cin >> a >> b;
        std::cout << "#" << test_case << " " << involve(a, b) << std::endl;
    }

    return 0;
}
