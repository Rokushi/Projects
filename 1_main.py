import os
import re

def file_creation_time(directory):
    file_creation_times = []
    for filename in os.listdir(directory):
        file_path = os.path.join(directory, filename)
        if os.path.isfile(file_path):
            creation_time = os.path.getctime(file_path)
            file_creation_times.append((filename, creation_time))
    return file_creation_times

def files_renaming_by_creation_time(directory):
    files_creation_times = file_creation_time(directory)
    files_creation_times.sort(key = lambda x: x[1])
    for index, (filename, creation_time) in enumerate(files_creation_times):
        new_name = re.sub(r'^\d+\_', '', filename)
        new_name = f"{index + 1}_{new_name}"
        old_path = os.path.join(directory, filename)
        new_path = os.path.join(directory, new_name)
        os.rename(old_path, new_path)
        print(f"{index + 1} из {len(files_creation_times)}")

if __name__ == '__main__':
    files_renaming_by_creation_time(os.getcwd())
    input("Файлы отсортированы\n"
          "Нажмите 'Enter' кнопку чтобы продолжить")