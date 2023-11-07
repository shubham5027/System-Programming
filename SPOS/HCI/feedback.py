import tkinter as tk
from tkinter import messagebox

def submit_feedback():
    customer_name = name_entry.get()
    feedback = feedback_entry.get("1.0", "end-1c")
    food_rating = food_rating_var.get()
    service_rating = service_rating_var.get()
    vegetarian = vegetarian_var.get()
    vegan = vegan_var.get()
    gluten_free = gluten_free_var.get()

  
    message = f"Thank you, {customer_name}, for your feedback!\n\n"
    message += f"Feedback: {feedback}\n"
    message += f"Food Rating: {food_rating}\n"
    message += f"Service Rating: {service_rating}\n"
    message += f"Vegetarian: {'Yes' if vegetarian else 'No'}\n"
    message += f"Vegan: {'Yes' if vegan else 'No'}\n"
    message += f"Gluten-Free: {'Yes' if gluten_free else 'No'}"

    messagebox.showinfo("Feedback Submitted", message)


root = tk.Tk()
root.title("Restaurant Feedback Form")


name_label = tk.Label(root, text="Customer Name:", font=("Arial", 12, "bold"))
feedback_label = tk.Label(root, text="Feedback:", font=("Arial", 12, "bold"))
food_label = tk.Label(root, text="Food Rating:", font=("Arial", 12, "bold"))
service_label = tk.Label(root, text="Service Rating:", font=("Arial", 12, "bold"))


name_entry = tk.Entry(root, width=30, font=("Arial", 12))


feedback_entry = tk.Text(root, height=5, width=30, font=("Arial", 12))


food_rating_var = tk.StringVar()
service_rating_var = tk.StringVar()


food_rating_1 = tk.Radiobutton(root, text="1", variable=food_rating_var, value="1", font=("Arial", 10))
food_rating_2 = tk.Radiobutton(root, text="2", variable=food_rating_var, value="2", font=("Arial", 10))
food_rating_3 = tk.Radiobutton(root, text="3", variable=food_rating_var, value="3", font=("Arial", 10))
food_rating_4 = tk.Radiobutton(root, text="4", variable=food_rating_var, value="4", font=("Arial", 10))
food_rating_5 = tk.Radiobutton(root, text="5", variable=food_rating_var, value="5", font=("Arial", 10))


service_rating_1 = tk.Radiobutton(root, text="1", variable=service_rating_var, value="1", font=("Arial", 10))
service_rating_2 = tk.Radiobutton(root, text="2", variable=service_rating_var, value="2", font=("Arial", 10))
service_rating_3 = tk.Radiobutton(root, text="3", variable=service_rating_var, value="3", font=("Arial", 10))
service_rating_4 = tk.Radiobutton(root, text="4", variable=service_rating_var, value="4", font=("Arial", 10))
service_rating_5 = tk.Radiobutton(root, text="5", variable=service_rating_var, value="5", font=("Arial", 10))


vegetarian_var = tk.IntVar()
vegan_var = tk.IntVar()
gluten_free_var = tk.IntVar()

vegetarian_checkbox = tk.Checkbutton(root, text="Vegetarian", variable=vegetarian_var, font=("Arial", 12))
vegan_checkbox = tk.Checkbutton(root, text="Vegan", variable=vegan_var, font=("Arial", 12))
gluten_free_checkbox = tk.Checkbutton(root, text="Gluten-Free", variable=gluten_free_var, font=("Arial", 12))


submit_button = tk.Button(root, text="Submit Feedback", command=submit_feedback, font=("Arial", 12), bg="green", fg="white")


name_label.grid(row=0, column=0, sticky="w")
name_entry.grid(row=0, column=1, columnspan=2, pady=5)
feedback_label.grid(row=1, column=0, sticky="w")
feedback_entry.grid(row=2, column=0, columnspan=3, pady=5)
food_label.grid(row=3, column=0, sticky="w")
food_rating_1.grid(row=3, column=1)
food_rating_2.grid(row=3, column=2)
food_rating_3.grid(row=3, column=3)
food_rating_4.grid(row=3, column=4)
food_rating_5.grid(row=3, column=5)
service_label.grid(row=4, column=0, sticky="w")
service_rating_1.grid(row=4, column=1)
service_rating_2.grid(row=4, column=2)
service_rating_3.grid(row=4, column=3)
service_rating_4.grid(row=4, column=4)
service_rating_5.grid(row=4, column=5)
vegetarian_checkbox.grid(row=5, column=0, sticky="w")
vegan_checkbox.grid(row=6, column=0, sticky="w")
gluten_free_checkbox.grid(row=7, column=0, sticky="w")
submit_button.grid(row=8, column=0, columnspan=3, pady=10)

root.mainloop()
