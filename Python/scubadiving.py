def find_paths(matrix, n, oxygen_capacity):
    def isValidMove(x, y) :
        return 0 <= x < n and 0 <= y < n and matrix[x][y] != 0
    
    def dfs(x, y, path, oxygen) :
        if matrix[x][y] == 9 :
            oxygen = oxygen_capacity
        oxygen -= matrix[x][y]
        if oxygen < 0:
            return
        
        if x == n-1 and (y == n-1 or y == 0) :
            if oxygen >= 0 :
                path.append((path, oxygen))
            return
        
        matrix[x][y] = 0
        for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)] :
            nx, ny = x + dx, y + dy
            if isValidMove(nx, ny) :
                dfs(nx, ny, path + directions[(dx, dy)], oxygen)

        matrix[x][y] = 1

    path = []
    directions = {(0, 1) : 'R', (1, 0) : 'D', (0, -1): 'L', (-1, 0): 'U'}
    dfs(0,0, '', oxygen_capacity)
    return path


def main() :

    find_paths()