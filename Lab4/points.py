def get_first_set_of_points():
    x_values = [0, -1.667, -2, -4, 1, 4]
    y_values = [5, 0, -1, -7, 8, 17]
    return x_values, y_values


def get_second_set_of_points():
    x_values = [0, 2, -4, 5, 6, 3]
    y_values = [0, 4, 16, 25, 36, 9]
    return x_values, y_values


def get_third_set_of_points():
    x_values = [0, 1.570796, 3.141592, -1, -0.61, 2]
    y_values = [1, 0, -1, 0.54, 0.82, -0.416]
    return x_values, y_values


def get_points(number):
    if number == 1:
        return get_first_set_of_points()
    if number == 2:
        return get_second_set_of_points()
    if number == 3:
        return get_third_set_of_points()


def print_points():
    print("Choose table of points: ")
    set_1 = get_first_set_of_points()
    set_2 = get_second_set_of_points()
    set_3 = get_third_set_of_points()
    print("1) x: " + str(set_1[0]) + "\n" + "   y: " + str(set_1[1]))
    print("2) x: " + str(set_2[0]) + "\n" + "   y: " + str(set_2[1]))
    print("3) x: " + str(set_3[0]) + "\n" + "   y: " + str(set_3[1]))
    return 0
