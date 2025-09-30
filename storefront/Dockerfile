#FROM gradle:8.11.1-jdk-21-and-23
#
#RUN apt-get update && apt-get install -qq -y --no-install-recommends
#
#ENV INSTALL_PATH /storefront
#
#RUN mkdir $INSTALL_PATH
#
#WORKDIR $INSTALL_PATH
#
#COPY . .


FROM gradle:8.11.1-jdk-21-and-23

# Set working directory
WORKDIR /storefront

# Copy everything
COPY . .

# Make sure the script can run
RUN chmod +x start-dev.sh

# Default command = run the app in dev mode
CMD ["./start-dev.sh"]
