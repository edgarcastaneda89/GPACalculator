import sqlite3

def calculate_gpa(total_gpa_points, num_courses):
    return total_gpa_points / num_courses

def main():
    con = sqlite3.connect("gpa.db")
    cvar = con.cursor()
    cvar.execute("""CREATE TABLE IF NOT EXISTS gpa(
                     number INTEGER PRIMARY KEY AUTOINCREMENT,
                     student_id INTEGER,
                     gpa DOUBLE);""")

    student_id = input("What is your Student ID? ")
    num_courses = int(input("How many classes did you take? "))

    total_gpa_points = 0

    for _ in range(num_courses):
        grade = input("Enter course grades (CAPITALIZED): ").upper()
        if grade == "A":
            total_gpa_points += 4
        elif grade == "B":
            total_gpa_points += 3
        elif grade == "C":
            total_gpa_points += 2
        elif grade == "D":
            total_gpa_points += 1
        elif grade == "F":
            total_gpa_points += 0
        else:
            print("Invalid Input, values can only be A, B, C, D, F")

    gpa = calculate_gpa(total_gpa_points, num_courses)

    cvar.execute("INSERT INTO gpa(student_id, gpa) VALUES(?,?);", (student_id, gpa))
    cvar.execute("SELECT gpa FROM gpa WHERE student_id=?", (student_id,))
    con.commit()

    past_gpa = cvar.fetchall()
    if len(past_gpa) > 1:
        str_gpa = str(past_gpa[-2]).replace("(", "")
        str_gpa = str_gpa.replace(",)", "")
        print("Your previous GPA was " + str_gpa)

    print("Your GPA now is " + str(gpa))
    con.close()

# calls the main function 
if __name__ == "__main__":

    main()
