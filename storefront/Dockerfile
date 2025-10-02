FROM gradle:8.11.1-jdk-21-and-23

# Set working directory
WORKDIR /storefront

# Copy everything
COPY . .

# Make sure the script can run
RUN chmod +x start-dev.sh

# Default command = run the app in dev mode
CMD ["./start-dev.sh"]
