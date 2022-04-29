import functions


def runge_kutta_solve(initial_y, function_id, h, borders):
    x_current = borders[0]
    y_current = initial_y
    points = [[borders[0], initial_y]]

    for i in range(int(borders[0]), int(borders[1] - h)):
        k1 = functions.get_function(function_id, x_current, y_current)
        k2 = functions.get_function(function_id, x_current + h / 2, y_current + h * k1 / 2)
        k3 = functions.get_function(function_id, x_current + h / 2, y_current + h * k2 / 2)
        k4 = functions.get_function(function_id, x_current + h, y_current + h * k3)

        dyi = (k1 + 2 * k2 + 2 * k3 + k4) * h / 6
        x_current += h
        y_current += dyi
        points.append([x_current, y_current])

    return points
