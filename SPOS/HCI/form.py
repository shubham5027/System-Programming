import tkinter as tk
from tkinter import ttk

def submit_form():
    name = entry_name.get()
    age = entry_age.get()
    gender = gender_var.get()
    courses = listbox_courses.curselection()

    # Process the form data (you can replace this with your logic)
    print(f"Name: {name}")
    print(f"Age: {age}")
    print(f"Gender: {gender}")
    print("Selected Courses:")
    for index in courses:
        print(listbox_courses.get(index))

# Create the main window
root = tk.Tk()
root.title("Student Registration Form")

# Create and configure style
style = ttk.Style()
style.configure('TLabel', font=('Arial', 14), padding=5)
style.configure('TEntry', font=('Arial', 14), padding=5)
style.configure('TButton', font=('Arial', 14), padding=5)
style.configure('TRadiobutton', font=('Arial', 14), padding=5)
style.configure('TCheckbutton', font=('Arial', 14), padding=5)

# Create and place widgets
label_name = ttk.Label(root, text="Name:")
label_name.grid(row=0, column=0, padx=10, pady=10, sticky=tk.E)

entry_name = ttk.Entry(root)
entry_name.grid(row=0, column=1, padx=10, pady=10, sticky=tk.W)

label_age = ttk.Label(root, text="Age:")
label_age.grid(row=1, column=0, padx=10, pady=10, sticky=tk.E)

entry_age = ttk.Entry(root)
entry_age.grid(row=1, column=1, padx=10, pady=10, sticky=tk.W)

label_gender = ttk.Label(root, text="Gender:")
label_gender.grid(row=2, column=0, padx=10, pady=10, sticky=tk.E)

gender_var = tk.StringVar()
male_radio = ttk.Radiobutton(root, text="Male", variable=gender_var, value="Male")
male_radio.grid(row=2, column=1, padx=10, pady=10, sticky=tk.W)
female_radio = ttk.Radiobutton(root, text="Female", variable=gender_var, value="Female")
female_radio.grid(row=2, column=2, padx=10, pady=10, sticky=tk.W)

label_courses = ttk.Label(root, text="Select Courses:")
label_courses.grid(row=3, column=0, padx=10, pady=10, sticky=tk.E)

course_options = ["Math", "Science", "History", "English"]
listbox_courses = tk.Listbox(root, selectmode=tk.MULTIPLE, exportselection=0, font=('Arial', 12), selectbackground='#A6A6A6')
for course in course_options:
    listbox_courses.insert(tk.END, course)
listbox_courses.grid(row=3, column=1, columnspan=2, padx=10, pady=10, sticky=tk.W)

submit_button = ttk.Button(root, text="Submit", command=submit_form)
submit_button.grid(row=4, column=0, columnspan=3, pady=10)

# Configure column weights for better layout
root.columnconfigure(0, weight=1)
root.columnconfigure(1, weight=1)
root.columnconfigure(2, weight=1)

# Run the main loop
root.mainloop()
