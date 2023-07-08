'''
# First I have installed 'qrcode' library
and
# 'tkinter' library
'''

# 'qrcode' library is used to generate the actual QR Code 
import qrcode

# 'tkinter' library is used to build GUI for data input
from tkinter import *

# 'tkinter' object is created
gui = Tk()

GUI_TITLE = "Sem II - Python Mini Project"
GUI_DIMENSION = '700x250'
GUI_YELLOW = '#f2e750'
GUI_LIGHT_BLACK = '#363529'
GUI_BLACK = '#000000'

gui.title(GUI_TITLE)
# setting the GUI window size and background color
gui.geometry(GUI_DIMENSION)
gui.config(bg=GUI_YELLOW)
gui.resizable(1,1)

# this function will generate the QR Code
def generate():
    img = qrcode.make(msg.get())
    type(img)
    img.save(f'{save_name.get()}.png')
    Label(gui, text='File Saved!', bg=GUI_YELLOW , border=20, fg='black', font=('Arial Black', 10)).pack()

# this function will show the QR Code on the press of button
def show():
    img = qrcode.make(msg.get())
    type(img)
    img.show()

frame = Frame(gui, bg=GUI_YELLOW, border=10, width=30)
frame.pack(expand=True)

# designing the label where we get input form user
# regarding for what we have to generate the QR
Label(frame, text='Enter any Text or URL to create the QR : ', font=('Arial Black', 12),
      bg=GUI_YELLOW).grid(row=0, column=0, sticky='w')

msg = Entry(frame)
msg.grid(row=0, column=1)

# designing the label where we get input form user
# regarding the file name in which we will save the QR
Label(frame, text='File Name (Used to save the file) : ', font=('Arial Black', 12),
      bg=GUI_YELLOW).grid(row=1, column=0, sticky='w')

save_name = Entry(frame)
save_name.grid(row=1, column=1)

# designing the button which will let user 
# to whether they want to show the QR or 
# they want save the QR
btn = Button(gui, text='Show QR code', bd='5', command=show, width=25)
btn.pack()
btn = Button(gui, text='Save QR code', command=generate, bd='5', width=15)
btn.pack()

gui.mainloop()