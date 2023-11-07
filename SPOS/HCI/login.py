import tkinter as tk
from tkinter import ttk, messagebox

def validate_login():
    username = entry_username.get()
    password = entry_password.get()

    # Add your authentication logic here
    # For simplicity, I'm using a basic check
    if username == "admin" and password == "password":
        messagebox.showinfo("Login Successful", "Welcome, {}".format(username))
    else:
        messagebox.showerror("Login Failed", "Invalid username or password")

# Create the main window
root = tk.Tk()
root.title("Login Window")

# Create and configure style
style = ttk.Style()
style.configure('TLabel', font=('Arial', 12))
style.configure('TEntry', font=('Arial', 12))
style.configure('TButton', font=('Arial', 12))

# Create and place widgets
label_username = ttk.Label(root, text="Username:")
label_username.grid(row=0, column=0, padx=10, pady=10, sticky=tk.E)

entry_username = ttk.Entry(root)
entry_username.grid(row=0, column=1, padx=10, pady=10)

label_password = ttk.Label(root, text="Password:")
label_password.grid(row=1, column=0, padx=10, pady=10, sticky=tk.E)

entry_password = ttk.Entry(root, show="*")
entry_password.grid(row=1, column=1, padx=10, pady=10)

login_button = ttk.Button(root, text="Login", command=validate_login)
login_button.grid(row=2, column=0, columnspan=2, pady=10)

# Run the main loop
root.mainloop()


