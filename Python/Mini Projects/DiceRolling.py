import random

diceArt = {
    1: ("┌─────────┐", 
        "|         |", 
        "|    ●    |", 
        "|         |", 
        "└─────────┘"),
    2: ("┌─────────┐",
        "| ●       |",
        "|         |",
        "|       ● |",
        "└─────────┘"),
    3: ("┌─────────┐",
        "| ●       |",
        "|    ●    |",
        "|       ● |",
        "└─────────┘"),
    4: ("┌─────────┐",
        "| ●     ● |",
        "|         |",
        "| ●     ● |",
        "└─────────┘"),
    5: ("┌─────────┐",
        "| ●     ● |",
        "|    ●    |",
        "| ●     ● |",
        "└─────────┘"),
    6: ("┌─────────┐",
        "| ●     ● |",
        "| ●     ● |",
        "| ●     ● |",
        "└─────────┘")}

rand = random.randint(1, 6)

for i in range(5) :
    print(diceArt.get(rand)[i])






# importing the tkinter module
from tkinter import *

# importing the pyperclip module to use it to copy our generated 
# password to clipboard
pip install pyperclip
import Pyperclip as pyperclip

# random module will be used in generating the random password
import random

# initializing the tkinter
root = Tk()

# setting the width and height of the gui
root.geometry("400x400")    # x is small case here

# declaring a variable of string type and this variable will be 
# used to store the password generated
passstr = StringVar()

# declaring a variable of integer type which will be used to 
# store the length of the password entered by the user
passlen = IntVar()

# setting the length of the password to zero initially
passlen.set(0)


# function to generate the password
def generate():
    # storing the keys in a list which will be used to generate 
    # the password 
    pass1 = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
            'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
            'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', 
            '9', '0', ' ', '!', '@', '#', '$', '%', '^', '&', 
            '*', '(', ')']

    # declaring the empty string
    password = ""

    # loop to generate the random password of the length entered           
    # by the user
    for x in range(passlen.get()):
        password = password + random.choice(pass1)

    # setting the password to the entry widget
    passstr.set(password)

# function to copy the password to the clipboard
def copytoclipboard():
    random_password = passstr.get()
    pyperclip.copy(random_password)

# Creating a text label widget
Label(root, text="Password Generator Application", font="calibri 20 bold").pack()

# Creating a text label widget
Label(root, text="Enter password length").pack(pady=3)

# Creating a entry widget to take password length entered by the 
# user
Entry(root, textvariable=passlen).pack(pady=3)

# button to call the generate function
Button(root, text="Generate Password", command=generate).pack(pady=7)

# entry widget to show the generated password
Entry(root, textvariable=passstr).pack(pady=3)

# button to call the copytoclipboard function
Button(root, text="Copy to clipboard", command=copytoclipboard).pack()

# mainloop() is an infinite loop used to run the application when 
# it's in ready state 
root.mainl









'''

# dice.py
import random

# ...

def roll_dice(num_dice):
    """Return a list of integers with length `num_dice`.

    Each integer in the returned list is a random number between
    1 and 6, inclusive.
    """
    roll_results = []
    for _ in range(num_dice):
        roll = random.randint(1, 6)
        roll_results.append(roll)
    return roll_results

# ~~~ App's main code block ~~~
# ...



# dice.py
# ...

# ~~~ App's main code block ~~~
# 1. Get and validate user's input
num_dice_input = input("How many dice do you want to roll? [1-6] ")
num_dice = parse_input(num_dice_input)
# 2. Roll the dice
roll_results = roll_dice(num_dice)

print(roll_results)  # Remove this line after testing the app




# $ python dice.py
# How many dice do you want to roll? [1-6] 5
# [6, 1, 3, 6, 6]

# $ python dice.py
# How many dice do you want to roll? [1-6] 2
# [2, 6]




# dice.py
import random

DICE_ART = {
    1: (
        "┌─────────┐",
        "│         │",
        "│    ●    │",
        "│         │",
        "└─────────┘",
    ),
    2: (
        "┌─────────┐",
        "│  ●      │",
        "│         │",
        "│      ●  │",
        "└─────────┘",
    ),
    3: (
        "┌─────────┐",
        "│  ●      │",
        "│    ●    │",
        "│      ●  │",
        "└─────────┘",
    ),
    4: (
        "┌─────────┐",
        "│  ●   ●  │",
        "│         │",
        "│  ●   ●  │",
        "└─────────┘",
    ),
    5: (
        "┌─────────┐",
        "│  ●   ●  │",
        "│    ●    │",
        "│  ●   ●  │",
        "└─────────┘",
    ),
    6: (
        "┌─────────┐",
        "│  ●   ●  │",
        "│  ●   ●  │",
        "│  ●   ●  │",
        "└─────────┘",
    ),
}
DIE_HEIGHT = len(DICE_ART[1])
DIE_WIDTH = len(DICE_ART[1][0])
DIE_FACE_SEPARATOR = " "

# ...




# dice.py

# ...

# def generate_dice_faces_diagram(dice_values):
#     """Return an ASCII diagram of dice faces from `dice_values`.

#     The string returned contains an ASCII representation of each die.
#     For example, if `dice_values = [4, 1, 3, 2]` then the string
#     returned looks like this:

#     ~~~~~~~~~~~~~~~~~~~ RESULTS ~~~~~~~~~~~~~~~~~~~
#     ┌─────────┐ ┌─────────┐ ┌─────────┐ ┌─────────┐
#     │  ●   ●  │ │         │ │  ●      │ │  ●      │
#     │         │ │    ●    │ │    ●    │ │         │
#     │  ●   ●  │ │         │ │      ●  │ │      ●  │
#     └─────────┘ └─────────┘ └─────────┘ └─────────┘
#     """
#     # Generate a list of dice faces from DICE_ART
#     dice_faces = []
#     for value in dice_values:
#         dice_faces.append(DICE_ART[value])

#     # Generate a list containing the dice faces rows
#     dice_faces_rows = []
#     for row_idx in range(DIE_HEIGHT):
#         row_components = []
#         for die in dice_faces:
#             row_components.append(die[row_idx])
#         row_string = DIE_FACE_SEPARATOR.join(row_components)
#         dice_faces_rows.append(row_string)

#     # Generate header with the word "RESULTS" centered
#     width = len(dice_faces_rows[0])
#     diagram_header = " RESULTS ".center(width, "~")

#     dice_faces_diagram = "\n".join([diagram_header] + dice_faces_rows)
#     return dice_faces_diagram

# # ~~~ App's main code block ~~~
# # ...






# dice.py

# ...

def generate_dice_faces_diagram(dice_values):
    """Return an ASCII diagram of dice faces from `dice_values`.

    The string returned contains an ASCII representation of each die.
    For example, if `dice_values = [4, 1, 3, 2]` then the string
    returned looks like this:

    ~~~~~~~~~~~~~~~~~~~ RESULTS ~~~~~~~~~~~~~~~~~~~
    ┌─────────┐ ┌─────────┐ ┌─────────┐ ┌─────────┐
    │  ●   ●  │ │         │ │  ●      │ │  ●      │
    │         │ │    ●    │ │    ●    │ │         │
    │  ●   ●  │ │         │ │      ●  │ │      ●  │
    └─────────┘ └─────────┘ └─────────┘ └─────────┘
    """
    dice_faces = _get_dice_faces(dice_values)
    dice_faces_rows = _generate_dice_faces_rows(dice_faces)

    # Generate header with the word "RESULTS" centered
    width = len(dice_faces_rows[0])
    diagram_header = " RESULTS ".center(width, "~")

    dice_faces_diagram = "\n".join([diagram_header] + dice_faces_rows)
    return dice_faces_diagram

def _get_dice_faces(dice_values):
    dice_faces = []
    for value in dice_values:
        dice_faces.append(DICE_ART[value])
    return dice_faces

def _generate_dice_faces_rows(dice_faces):
    dice_faces_rows = []
    for row_idx in range(DIE_HEIGHT):
        row_components = []
        for die in dice_faces:
            row_components.append(die[row_idx])
        row_string = DIE_FACE_SEPARATOR.join(row_components)
        dice_faces_rows.append(row_string)
    return dice_faces_rows

# ~~~ App's main code block ~~~
# ...






# dice.py

# ...

# ~~~ App's main code block ~~~
# 1. Get and validate user's input
num_dice_input = input("How many dice do you want to roll? [1-6] ")
num_dice = parse_input(num_dice_input)
# 2. Roll the dice
roll_results = roll_dice(num_dice)
# 3. Generate the ASCII diagram of dice faces
dice_face_diagram = generate_dice_faces_diagram(roll_results)
# 4. Display the diagram
print(f"\n{dice_face_diagram}")



'''