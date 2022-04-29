import functions


def runge_kutta_solve(initial_point, function_id, h, n):
    x_current = initial_point[0]
    y_current = initial_point[1]
    points = [[x_current, y_current]]
    for i in range(1, n):
        k1 = functions.get_function(function_id, x_current, y_current)
        k2 = functions.get_function(function_id, x_current + h / 2, y_current + h * k1 / 2)
        k3 = functions.get_function(function_id, x_current + h / 2, y_current + h * k2 / 2)
        k4 = functions.get_function(function_id, x_current + h, y_current + h * k3)

        dyi = (k1 + 2 * k2 + 2 * k3 + k4) * h / 6
        x_current += h
        y_current += dyi
        points.append([x_current, y_current])

    return points
