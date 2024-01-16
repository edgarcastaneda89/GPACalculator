#!/bin/bash

# Get date and time
current_date=$(date +"%Y-%m-%d")
current_time=$(date +"%H:%M")

# Intro
echo "Welcome to Calc Inc! Please follow instructions carefully :)"

function get_semester() {
    read -p "Are you in the fall or spring semester? Type in exactly \"fall\" or \"spring\": " semester_type

    if [[ "$semester_type" == "fall" ]]; then
        semester="Fall Semester"
    elif [[ "$semester_type" == "spring" ]]; then
        semester="Spring Semester"
    else
        echo "Invalid semester selection. Please choose 'fall' or 'spring'. "
        get_semester
    fi
}

function get_quarter() {
    read -p "Which quarter are you in? Type in exactly \"fall\", \"winter\", \"spring\", or \"summer\": " quarter_type
    if [[ "$quarter_type" == "fall" ]]; then
        quarter="Fall Quarter"
    elif [[ "$quarter_type" == "winter" ]]; then
        quarter="Winter Quarter"
    elif [[ "$quarter_type" == "spring" ]]; then
        quarter="Spring Quarter"
    elif [[ "$quarter_type" == "summer" ]]; then
        quarter="Summer Quarter"
    else
        echo " "
        echo "Invalid input. Please choose 'fall', 'winter', 'spring', or 'summer' spelled exactly as written."
        get_quarter
    fi
}

# Ask if the student is in a semester or quarter system
while true; do
    echo " "
    read -p "Are you in a semester or quarter system? Type in exactly \"semester\" or \"quarter\": " system_type

    if [[ "$system_type" == "semester" ]]; then
        get_semester
        echo  
        break
    elif [[ "$system_type" == "quarter" ]]; then
        get_quarter
        echo  
        break
    else
        echo "Invalid Input. Please choose 'semester' or 'quarter' written exactly as spelled."
    fi
done

echo "Date: $current_date"
echo "Time: $current_time"
if [[ -n "$semester" ]]; then
    echo "Semester: $semester"
else
    echo "Quarter: $quarter"
fi
