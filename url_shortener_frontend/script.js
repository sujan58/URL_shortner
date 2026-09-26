const urlInput = document.getElementById("urlInput");
const shortenButton = document.getElementById("shortenButton");
const result = document.getElementById("result");

shortenButton.addEventListener("click", shortenUrl);

async function shortenUrl() {

    const originalUrl = urlInput.value.trim();
    if((!originalUrl.includes(".com")) && ((!originalUrl.includes("http://"))|| (!originalUrl.includes("https://")))){
        console.log(originalUrl.includes("https://"));
        alert("Please enter a valid url");
        return;
    }

    try {

        const response = await fetch("http://localhost:8080/api/v1/", {
            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                originalUrl: originalUrl
            })
        });

        if (!response.ok) {
            throw new Error("Failed to shorten URL");
        }

        const data = await response.json();

        result.innerHTML = `
            <p>Shortened URL:</p>

            <a href="${data.shortenUrl}" target="_blank">
                ${data.shortenUrl}
            </a>
        `;

    } catch (error) {

        console.error(error);

        result.innerHTML = `
            <p>Something went wrong.</p>
        `;
    }
}