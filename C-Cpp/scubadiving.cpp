#include <iostream>
#include <vector>
#include <utility>
#include <cstring>

using namespace std;

vector<string> paths;
vector<pair<string, int>> feasible_paths;

bool is_valid_move(int x, int y, int n, vector<vector<int>>& matrix) {
    return x >= 0 && x < n && y >= 0 && y < n && matrix[x][y] != 0;
}

void explore_path(int x, int y, int n, vector<vector<int>>& matrix, int M, string path, int oxygen, bool visited[][10]) {
    if (x == n - 1 && (y == n - 1 || y == 0)) { // Reached destination
        paths.push_back(path);
        feasible_paths.push_back(make_pair(path, oxygen));
        return;
    }

    int dx[] = {0, 1, 0, -1}; // Right, Down, Left, Up
    int dy[] = {1, 0, -1, 0};
    for (int i = 0; i < 4; ++i) {
        int new_x = x + dx[i];
        int new_y = y + dy[i];
        if (is_valid_move(new_x, new_y, n, matrix) && !visited[new_x][new_y]) {
            int new_oxygen = oxygen - (matrix[new_x][new_y] + matrix[x][y]);
            if (matrix[new_x][new_y] == 9) {
                new_oxygen = M;
            }
            if (new_oxygen >= 0) {
                visited[new_x][new_y] = true;
                explore_path(new_x, new_y, n, matrix, M, path + (i == 0 ? 'R' : (i == 1 ? 'D' : (i == 2 ? 'L' : 'U'))), new_oxygen, visited);
                visited[new_x][new_y] = false;
            }
        }
    }
}

int main() {
    int n, M;
    cin >> n;

    vector<vector<int>> matrix(n, vector<int>(n));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> matrix[i][j];
        }
    }

    cin >> M;

    bool visited[10][10];
    memset(visited, false, sizeof(visited));

    explore_path(0, 0, n, matrix, M, "S", M, visited);

    cout << "The available paths are" << endl;
    for (string path : paths) {
        cout << path << endl;
    }

    cout << "\nThe feasible paths with remaining oxygen levels are" << endl;
    for (auto p : feasible_paths) {
        cout << p.first << " " << p.second << endl;
    }

    return 0;
}