#include <iostream>
#include <stack>
#include <string>

const char get_opposite(const char& c)
{
    switch (c) {
        case '{': return '}';
        case '[': return ']';
        case '(': return ')';
        case '<': return '>';
        case '}': return '{';
        case ']': return '[';
        case ')': return '(';
        case '>': return '<';
        default: return ' ';
    }
}

const std::string opening_token = "{[(<";
const std::string closing_token = "}])>";

const bool is_closing_token(const char& c)
{
    return closing_token.find(c) != std::string::npos;
}

const bool is_opening_token(const char& c)
{
    return opening_token.find(c) != std::string::npos;
}

const bool check(const std::string& str)
{
    unsigned int i;
    bool valid = true;
    std::stack<char> token_stack;
    for (i = 0; i != str.size(); ++i)
    {
        const char c_char = str[i];
        const char o_char = get_opposite(c_char);
        if (o_char != ' ')
        {
            if (is_opening_token(c_char))
            {
                token_stack.push(c_char);
            }
            else
            {
                if (token_stack.size() > 0 && o_char == token_stack.top())
                {
                    token_stack.pop();
                }
                else
                {
                    valid = false;
                    break;
                }
            }
        }
    }
    valid = valid && token_stack.size() == 0;
    return valid;
}

int main(int argc, const char** argv)
{
    const unsigned int maximum_test_cases = 10;
    unsigned int test_case, i;
    std::string str;
    for (i = 0; i != maximum_test_cases; ++i)
    {
        std::cin >> test_case;
        std::cin >> str;
        std::cout << "#" << (i + 1) << " " << (check(str) ? "1" : "0") << std::endl;
    }
    return 0;
}
