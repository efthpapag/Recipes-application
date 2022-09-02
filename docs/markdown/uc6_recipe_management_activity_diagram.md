# UC6 Management of recipes
**Primary Actor**: User
**Interested**
**User**: Wants to submit or delete or edit recipes.
**Conditions**: The user must be logged into the app with their account.
## Basic Flow

### A) Submission of a new prescription.

1. The user goes to the recipe management page.
2. The application displays the table where the user can see the recipes he has already submitted.
3. The user presses the "submit new prescription" option.
4. The application sends the user to the prescription information filling page.
5. The user states the name, the ingredients included in the recipe, the time of its completion, the portions that result from these proportions of ingredients, the type of meal and the steps to execute the recipe.
6. The user confirms the submission of the prescription.
7. The recipe is added to the application.

**Alternative Streams**

*5a The application does not accept a field.*
1. The user does not fill in a field or fills it in incorrectly.
2. The application informs him accordingly.
*6a The user does not complete the prescription declaration.*
1. The user does not complete the prescription statement.

### B) Delete prescription.

1. 1 The user goes to the recipe management page.
2. The application displays the table where the user can see the recipes he has already submitted.
3. The user presses the “Delete” option.
4. The user confirms the deletion of the recipe.
5. The prescription is deleted from the application.

**Alternative Streams**

*4a The user does not complete the deletion of the prescription.*
1. The user does not complete the prescription deletion.

### C) Edit recipe.

1. The user goes to the recipe management page.
2. The application displays the table where the user can see the recipes he has already submitted.
3. The user taps the “Edit Recipe” option
4. The application sends the user to the prescription information filling page.
5. The user states the name, the ingredients included in the recipe, the time of its completion, the portions that result from these proportions of ingredients, the type of meal and the steps to execute the recipe.
6. The user confirms the submission of the prescription.
7. The recipe is added to the application.

**Alternative Streams**

*5a The application does not accept a field.*
1. The user does not fill in a field or fills it in incorrectly.
2. The application informs him accordingly.
*6a The user does not complete the processing of the recipe.*
1. The user does not complete the processing of the recipe.


### Activity chart
![](uml/requirements/recipe_management_activity_diagram.png)
