const apiUrl = "http://localhost:8080/users";

// Enhanced form submission with visual feedback
document.getElementById("registerForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    
    const submitBtn = e.target.querySelector('.submit-btn');
    const originalText = submitBtn.textContent;
    const usernameInput = document.getElementById("username");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");
    
    // Reset input states
    [usernameInput, emailInput, passwordInput].forEach(input => {
        input.classList.remove('error', 'success');
    });
    
    const user = {
        username: usernameInput.value.trim(),
        email: emailInput.value.trim(),
        password: passwordInput.value
    };
    
    // Basic validation
    if (!user.username || !user.email || !user.password) {
        if (!user.username) usernameInput.classList.add('error');
        if (!user.email) emailInput.classList.add('error');
        if (!user.password) passwordInput.classList.add('error');
        return;
    }
    
    try {
        // Show loading state
        submitBtn.textContent = 'Creating Account...';
        submitBtn.disabled = true;
        
        const response = await fetch(apiUrl, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(user)
        });
        
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        
        // Success feedback
        [usernameInput, emailInput, passwordInput].forEach(input => {
            input.classList.add('success');
        });
        
        const formContainer = document.querySelector('.form-container');
        formContainer.classList.add('success-animation');
        
        setTimeout(() => {
            formContainer.classList.remove('success-animation');
        }, 600);
        
        // Reset form
        e.target.reset();
        
        // Remove success classes after animation
        setTimeout(() => {
            [usernameInput, emailInput, passwordInput].forEach(input => {
                input.classList.remove('success');
            });
        }, 1000);
        
    } catch (error) {
        console.error('Error registering user:', error);
        
        // Show error state
        [usernameInput, emailInput, passwordInput].forEach(input => {
            input.classList.add('error');
        });
        
        setTimeout(() => {
            [usernameInput, emailInput, passwordInput].forEach(input => {
                input.classList.remove('error');
            });
        }, 2000);
    } finally {
        // Reset button
        setTimeout(() => {
            submitBtn.textContent = originalText;
            submitBtn.disabled = false;
        }, 1000);
    }
});

// Add input animation effects
document.addEventListener('DOMContentLoaded', function() {
    const inputs = document.querySelectorAll('.form-input');
    
    inputs.forEach(input => {
        input.addEventListener('focus', function() {
            this.style.transform = 'translateY(-2px)';
        });
        
        input.addEventListener('blur', function() {
            this.style.transform = 'translateY(0)';
        });
    });
});