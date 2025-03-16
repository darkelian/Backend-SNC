FROM python:3.13.2-bullseye
ENV PYTHONUNBUFFERED=1
WORKDIR /code
COPY requirements.txt /code/
RUN apt-get update && apt-get install -y python-dev libsasl2-dev libssl-dev

# Install GDAL dependencies
RUN apt-get install -y libgdal-dev g++ --no-install-recommends && \
    apt-get clean -y

RUN pip install -r requirements.txt
COPY . /code/